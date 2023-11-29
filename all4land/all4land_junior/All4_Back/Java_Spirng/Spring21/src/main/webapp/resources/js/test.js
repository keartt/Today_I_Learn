window.onload = function() {
  //5179 좌표계 보정
  proj4.defs("EPSG:5179",
     "+proj=tmerc +lat_0=38 +lon_0=127.5 +k=0.9996 +x_0=1000000 +y_0=2000000 +ellps=GRS80 +towgs84=0,0,0,0,0,0,0 +units=m +no_defs"
  );

  ol.proj.proj4.register(proj4);

  var projection = new ol.proj.Projection({
     code: "EPSG:5179",
     units: 'm',
     axisOrientation: 'neu',
  });

  //위경도 좌표
  const initPosition = ol.proj.fromLonLat([128, 36], projection);

  // 배경 이미지(tile) E-map
  var baseLyr1 = new ol.layer.Tile({
     source: new ol.source.WMTS({
     crossOrigin: "anonymous",
        projection: projection,
        tileGrid: new ol.tilegrid.WMTS({
           extent: [-200000.0, -3015.4524155292, 3803015.45241553, 4000000.0],
           matrixIds: [
              "L05",
              "L06",
              "L07",
              "L08",
              "L09",
              "L10",
              "L11",
              "L12",
              "L13",
              "L14",
              "L15",
              "L16",
              "L16",
              "L17",
              "L18"
           ],
           resolutions: [
              2088.96,
              1044.48,
              522.24,
              261.12,
              130.56,
              65.28,
              32.64,
              16.32,
              8.16,
              4.08,
              2.04,
              1.02,
              0.51,
              0.255
           ]
        }),
        layer: "korean_map",
        style: "korean",
        format: "image/png",
        matrixSet: "korean",
        url: "http://map.ngii.go.kr/openapi/Gettile.do?apikey=04trYP9_xwLAfALjwZ-B8g",
        tileLoadFunction: function(imageTile, src) {
           src = src.replace("TileMatrix", "tilematrix");
           src = src.replace("TileRow", "tilerow");
           src = src.replace("TileCol", "tilecol");
           imageTile.getImage().src = src;
        }
     })
  });


  // wms 시작
  // wms 레이어 목록
  let wmslist = {
     te_scco_sid_wms: {
        value: "te_scco_sid",
        visible: false,
        index: 2
     },
      te_scco_sgg_ln_wms: {
          value: "te_scco_sgg_ln",
          visible: false,
          index: 3
      }

  };

  var values = Object.values(wmslist);

  // wms layer list 불러오는 함수
  function getLayers() {
     let list = [];
     for (let i = 0; i < values.length; i++) {
        if (values[i].visible === true) {
           list.push(values[i].value);
        }
     }
     return list;
  }

  const wmsSource = new ol.source.ImageWMS({
     url: "http://localhost:8090/geoserver/all4land/wms",
     params: {
        LAYERS: getLayers(),
        VERSION: "1.1.0"
     }
  });

  const wmsLayer = new ol.layer.Image({
     source: wmsSource
  });
  // wms 종료


  // view object
  const view = new ol.View({
     center: initPosition,
     zoom: 8,
     projection: projection
  });

  var LAYERS = [baseLyr1, wmsLayer];

  // Map object
  const map = new ol.Map({
     target: "map",
     view: view,
     layers: LAYERS
  });


     //맵 다운로드 시작
       document.getElementById("export-png").addEventListener("click", function () {
           map.once("rendercomplete", function () {
               const mapCanvas = document.createElement("canvas");
               const size = map.getSize();
               mapCanvas.width = size[0];
               mapCanvas.height = size[1];
               const mapContext = mapCanvas.getContext("2d");
               Array.prototype.forEach.call(
                   map.getViewport().querySelectorAll(".ol-layer canvas, canvas.ol-layer"),
                   function (canvas) {
                       if (canvas.width > 0) {
                           const opacity =
                               canvas.parentNode.style.opacity || canvas.style.opacity;
                           mapContext.globalAlpha = opacity === "" ? 1 : Number(opacity);

                           const backgroundColor = canvas.parentNode.style.backgroundColor;
                           if (backgroundColor) {
                               mapContext.fillStyle = backgroundColor;
                               mapContext.fillRect(0, 0, canvas.width, canvas.height);
                           }

                           let matrix;
                           const transform = canvas.style.transform;
                           if (transform) {
                               // Get the transform parameters from the style's transform matrix
                               matrix = transform
                                   .match(/^matrix\(([^\(]*)\)$/)[1]
                                   .split(",")
                                   .map(Number);
                           } else {
                               matrix = [
                                   parseFloat(canvas.style.width) / canvas.width,
                                   0,
                                   0,
                                   parseFloat(canvas.style.height) / canvas.height,
                                   0,
                                   0
                               ];
                           }
                           // Apply the transform to the export map context
                           CanvasRenderingContext2D.prototype.setTransform.apply(
                               mapContext,
                               matrix
                           );
                           mapContext.drawImage(canvas, 0, 0);
                       }
                   }
               );
               mapContext.globalAlpha = 1;
               if (navigator.msSaveBlob) {
                   // link download attribute does not work on MS browsers
                   navigator.msSaveBlob(mapCanvas.msToBlob(), "map.png");
               } else {
                   const link = document.getElementById("image-download");
                   link.href = mapCanvas.toDataURL();
                   link.click();
               }
           });
           map.renderSync();
       });
     //다운로드 끝

  
//클릭 시작
  map.on('singleclick', function(evt) {
 var viewResolution = map.getView().getResolution();
 var url = wmsSource.getFeatureInfoUrl(
   evt.coordinate, viewResolution, 'EPSG:5179',
   {'INFO_FORMAT': 'application/json', 'propertyName': 'sid_cd,kor_sid_nm,eng_sid_nm'}
 );
 
 $.ajax({
   url: url,
   success: function(data) {
     if (data.features.length > 0) {
       var properties = data.features[0].properties;
       var sid_cd = properties.sid_cd;
       var kor_sid_nm = properties.kor_sid_nm;
       var eng_sid_nm = properties.eng_sid_nm;
       alert('SID Code: ' + sid_cd + '\nKorean Station Name: ' + kor_sid_nm + '\nEnglish Station Name: ' + eng_sid_nm);
     } else {
       console.log('No feature clicked.');
     }
   }
 });
});
  


  //click event - wms
  //wms 레이어 on/off
  const checkBoxElements = document.querySelectorAll(
     "input[type=checkbox]"
  );
  for (let checkBoxElement of checkBoxElements) {
      checkBoxElement.addEventListener("change", function (event) {
        
        let checkLayer; 
     
        if(event.target.value == 'te_scco_sid_wms' ){
           checkLayer = wmslist[event.target.value];
             this.checked ?
                 (checkLayer.visible = true) :
                 (checkLayer.visible = false);
     
             wmsLayer.getSource().updateParams({
                 LAYERS: getLayers()
             });
     
             if (getLayers().length === 0) {
                 wmsLayer.setVisible(false);
             } else {
                 wmsLayer.setVisible(true);
             }
           
           }else if(event.target.value == 'te_scco_sgg_ln_wms' ){
           checkLayer = wmslist[event.target.value];
             this.checked ?
                 (checkLayer.visible = true) :
                 (checkLayer.visible = false);
     
             wmsLayer.getSource().updateParams({
                 LAYERS: getLayers()
             });
     
             if (getLayers().length === 0) {
                 wmsLayer.setVisible(false);
             } else {
                 wmsLayer.setVisible(true);
             }
  

      }
});
  }

}


/*
window.onload = function(){
  proj4.defs("EPSG:5179",
     "+proj=tmerc +lat_0=38 +lon_0=127.5 +k=0.9996 +x_0=1000000 +y_0=2000000 +ellps=GRS80 +towgs84=0,0,0,0,0,0,0 +units=m +no_defs"
  );

  ol.proj.proj4.register(proj4);

  var projection = new ol.proj.Projection({
     code: "EPSG:5179",
     units: 'm',
     axisOrientation: 'enu',
  });

  //위경도 좌표
  const initPosition = ol.proj.fromLonLat([128, 36], projection);

  // 배경 이미지(tile) E-map
  var baseLyr1 = new ol.layer.Tile({
     source: new ol.source.WMTS({
        projection: projection,
        tileGrid: new ol.tilegrid.WMTS({
           extent: [-200000.0, -3015.4524155292, 3803015.45241553, 4000000.0],
           matrixIds: [
              "L05",
              "L06",
              "L07",
              "L08",
              "L09",
              "L10",
              "L11",
              "L12",
              "L13",
              "L14",
              "L15",
              "L16",
              "L16",
              "L17",
              "L18"
           ],
           resolutions: [
              2088.96,
              1044.48,
              522.24,
              261.12,
              130.56,
              65.28,
              32.64,
              16.32,
              8.16,
              4.08,
              2.04,
              1.02,
              0.51,
              0.255
           ]
        }),
        layer: "korean_map",
        style: "korean",
        format: "image/png",
        matrixSet: "korean",
        url: "http://map.ngii.go.kr/openapi/Gettile.do?apikey=04trYP9_xwLAfALjwZ-B8g",
        tileLoadFunction: function (imageTile, src) {
           src = src.replace("TileMatrix", "tilematrix");
           src = src.replace("TileRow", "tilerow");
           src = src.replace("TileCol", "tilecol");
           imageTile.getImage().src = src;
        }
     })
  });


  // wms 시작
  // wms 레이어 목록
  let wmslist = {
      te_scco_sid_wms: {
          value: "te_scco_sid",
          visible: false,
          index: 2
      },
      te_scco_sgg_ln_wms: {
          value: "te_scco_sgg_ln",
          visible: false,
          index: 3
      }
  };
  
  var values = Object.values(wmslist);
  
  // wms layer list 불러오는 함수
  function getLayers() {
      let list = [];
      for (let i = 0; i < values.length; i++) {
          if (values[i].visible === true) {
              list.push(values[i].value);
          }
      }
      return list;
  }
  
  const wmsSource = new ol.source.ImageWMS({
     url: "http://localhost:8090/geoserver/all4land/wms",
      params: {
          LAYERS: getLayers(),
          VERSION: "1.1.0"
      }
  });

  const wmsLayer = new ol.layer.Image({
      source: wmsSource
  });
  // wms 종료


  // wfs 시작
  const vectorSource = new ol.source.Vector();
  const wfsLayer = new ol.layer.Vector({
     source: vectorSource,
     style: new ol.style.Style({
        stroke: new ol.style.Stroke({
              color: "rgba(0, 0, 255, 1.0)",
              width: 2
         })
       }),
     visible: false
  });
  
  const featureRequest = new ol.format.WFS().writeGetFeature({
     srsName: "EPSG:5179",
       featureNS: "http://localhost:8090/geoserver",
       featurePrefix: "all4land",
       featureTypes: ["te_scco_sid"],
       outputFormat: "application/json"
  });
  
  fetch('http://localhost:8090/geoserver/all4land/ows', {
      method: 'POST',
      body: new XMLSerializer().serializeToString(featureRequest),
    }).then(function (response) {
      return response.json();
    }).then(function (json) {
      const features = new ol.format.GeoJSON().readFeatures(json);
      vectorSource.addFeatures(features);
    });
  // wfs 종료

  // view object
  const view = new ol.View({
     center: initPosition,
     zoom: 8,
     projection : projection
  });

  var LAYERS = [baseLyr1, wmsLayer, wfsLayer];

// Map object
  const map = new ol.Map({
     target: "map",
     view: view,
     layers: LAYERS
  });
  
  //지도 저장
    //map export
       document.getElementById("export-png").addEventListener("click", function () {
           map.once("rendercomplete", function () {
               const mapCanvas = document.createElement("canvas");
               const size = map.getSize();
               mapCanvas.width = size[0];
               mapCanvas.height = size[1];
               const mapContext = mapCanvas.getContext("2d");
               Array.prototype.forEach.call(
                   map.getViewport().querySelectorAll(".ol-layer canvas, canvas.ol-layer"),
                   function (canvas) {
                       if (canvas.width > 0) {
                           const opacity =
                               canvas.parentNode.style.opacity || canvas.style.opacity;
                           mapContext.globalAlpha = opacity === "" ? 1 : Number(opacity);

                           const backgroundColor = canvas.parentNode.style.backgroundColor;
                           if (backgroundColor) {
                               mapContext.fillStyle = backgroundColor;
                               mapContext.fillRect(0, 0, canvas.width, canvas.height);
                           }

                           let matrix;
                           const transform = canvas.style.transform;
                           if (transform) {
                               // Get the transform parameters from the style's transform matrix
                               matrix = transform
                                   .match(/^matrix\(([^\(]*)\)$/)[1]
                                   .split(",")
                                   .map(Number);
                           } else {
                               matrix = [
                                   parseFloat(canvas.style.width) / canvas.width,
                                   0,
                                   0,
                                   parseFloat(canvas.style.height) / canvas.height,
                                   0,
                                   0
                               ];
                           }
                           // Apply the transform to the export map context
                           CanvasRenderingContext2D.prototype.setTransform.apply(
                               mapContext,
                               matrix
                           );
                           mapContext.drawImage(canvas, 0, 0);
                       }
                   }
               );
               mapContext.globalAlpha = 1;
               if (navigator.msSaveBlob) {
                   // link download attribute does not work on MS browsers
                   navigator.msSaveBlob(mapCanvas.msToBlob(), "map.png");
               } else {
                   const link = document.getElementById("image-download");
                   link.href = mapCanvas.toDataURL();
                   link.click();
               }
           });
           map.renderSync();
       });
  
  
  
  //click event - wms
  //wms 레이어 on/off
  const checkBoxElements = document.querySelectorAll(
      "input[type=checkbox]"
  );
  for (let checkBoxElement of checkBoxElements) {
      checkBoxElement.addEventListener("change", function (event) {
        
        let checkLayer; 
     
        if(event.target.value == 'te_scco_sid_wms' ){
           checkLayer = wmslist[event.target.value];
             this.checked ?
                 (checkLayer.visible = true) :
                 (checkLayer.visible = false);
     
             wmsLayer.getSource().updateParams({
                 LAYERS: getLayers()
             });
     
             if (getLayers().length === 0) {
                 wmsLayer.setVisible(false);
             } else {
                 wmsLayer.setVisible(true);
             }
           
           }else if(event.target.value == 'te_scco_sgg_ln_wms' ){
           checkLayer = wmslist[event.target.value];
             this.checked ?
                 (checkLayer.visible = true) :
                 (checkLayer.visible = false);
     
             wmsLayer.getSource().updateParams({
                 LAYERS: getLayers()
             });
     
             if (getLayers().length === 0) {
                 wmsLayer.setVisible(false);
             } else {
                 wmsLayer.setVisible(true);
             }
     

        }else if(event.target.value == 'te_scco_sid_wfs' ){
           this.checked ?
                 wfsLayer.setVisible(true) :
                 wfsLayer.setVisible(false);
        }

      });
  }
  
}
*/
  
