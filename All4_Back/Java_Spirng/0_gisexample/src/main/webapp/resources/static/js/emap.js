let attSearch, regTarget = false;

window.onload = function(){
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
	        index: 1
	    },
	    te_scco_sgg_ln_wms: {
	        value: "te_scco_sgg_ln",
	        visible: false,
	        index: 2
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
		url: "http://localhost:8081/geoserver/all4land/wms",
		crossOrigin: "anonymous",
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
	const dbLayer = new ol.layer.Vector({
		source: vectorSource,
		visible: true
	});
	// wfs 종료
	
	// view object
	const view = new ol.View({
		center: initPosition,
		zoom: 8,
		projection : projection
	});

	var LAYERS = [baseLyr1, wmsLayer, dbLayer];

	// Map object
	const map = new ol.Map({
		target: "map",
		view: view,
		layers: LAYERS
	});
	
	
	
	
	//click event - wms
	//wms 레이어 on/off
	const checkBoxElements = document.querySelectorAll(
	    "input[type=checkbox]"
	);
	
	for (let checkBoxElement of checkBoxElements) {
	    checkBoxElement.addEventListener("change", function (event) {
			
			if($('#attSearch').is(':checked') && $('#regTarget').is(':checked')){
				alert('속성조회 및 좌표등록은 하나만 체크 하여주십시요.');
				if(event.target.checked){
					event.target.checked = false;
				}else{
					event.target.checked = true;
				}
				return;
			}
			
			if(event.target.id == 'attSearch'){
				if(event.target.checked == false){
					$('.attrDiv').css('display', 'none');
				}else if(wmslist['te_scco_sid_wms'].visible){
					$('.attrDiv').css('display', 'block');
				}else{
					alert('te_scco_sid_wms layer를 조회 해주십시요.');
					event.target.checked = false;
				}
				return;
			}else if(event.target.id == 'regTarget'){
				$('.attrDiv').css('display', 'none');
				return;
			}else{
				$('.attrDiv').css('display', 'none');
			}
			
						
			let checkLayer = wmslist[event.target.value];
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
	    });
	}
	
	map.on('click', function(evt){
		if($('#attSearch').is(':checked')){
			let searchPoint = new ol.geom.Point(evt.coordinate);
			const featureRequest = new ol.format.WFS().writeGetFeature({
				srsName: "EPSG:5179",
			  	featureNS: "http://localhost:8081/geoserver",
			  	featurePrefix: "all4land",
			  	featureTypes: ["te_scco_sid"],
			  	outputFormat: "application/json",
				filter: ol.format.filter.intersects('geom', searchPoint, 'EPSG:5179')
			});
			
			fetch('http://localhost:8081/geoserver/all4land/ows', {
		    	method: 'POST',
		    	body: new XMLSerializer().serializeToString(featureRequest),
		  	}).then(function (response) {
		    	return response.json();
		  	}).then(function (json) {
				$('#sid_cd').val(json.features[0].properties.sid_cd);
				$('#kor_sid_nm').val(json.features[0].properties.kor_sid_nm);
				$('#eng_sid_nm').val(json.features[0].properties.eng_sid_nm);
		  	});			
	
		}else if($('#regTarget').is(':checked')){
			let coordinate = evt.coordinate;
			$.ajax({
				url : getContextPath()+"/regPoint",
				type : "get",
				data : {"coordX":coordinate[0], "coordY":coordinate[1]},
				success : function(responseData){
					alert(responseData.rtn);
				}
			})
			
		}
	});
	
	//등록정보 조회 버튼 이벤트
	$('#regTargetSearch').click(function(){
		$.ajax({
			url : getContextPath()+"/regPointSearch",
			type : "get",
			success : function(responseData){
				//alert(responseData.rtn);
				var aFeatures = [];
				for (let idx in responseData.rtn){
					var oFeature = new ol.Feature({
          				geometry: new ol.geom.Point([responseData.rtn[idx].coordx, responseData.rtn[idx].coordy]),
						name: 'point_'+idx
      				});
      				aFeatures.push(oFeature);
									
				}
    			
				vectorSource.addFeatures(aFeatures);
			}
		})
	});
	
	
	//화면저장 버튼 이벤트
	$('#saveMap').click(function(){
		map.once('rendercomplete', function (e) {
			const canvas = e.target.getViewport().querySelector('canvas');
			const mapContext = canvas.getContext('2d');

			if($('.attrDiv').css('display') == 'block'){
				const attrDiv = document.querySelector('.attrDiv');
				html2canvas(attrDiv).then(function(attrDivCanvas){
					mapContext.drawImage(attrDivCanvas, 10, 10);
					mapContext.canvas.toBlob(function(blob) {
						saveAs(blob, 'map.png');
					});
				});				
			}else{
				canvas.toBlob((blob)=>{
					saveAs(blob, 'map.png');
				});				
			}
		});
		map.renderSync();
	});	
	
	//context 조회 함수
	function getContextPath() {
		var hostIndex = location.href.indexOf( location.host ) + location.host.length;
		return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
	};
}