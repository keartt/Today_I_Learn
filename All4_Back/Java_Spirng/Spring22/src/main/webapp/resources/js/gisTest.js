window.onload = function() {
	console.log("hi")
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
			crossOrigin: "annonymous",
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

		te_scco_sgg_ln: {
			value: "te_scco_sgg_ln",
			visible: false,
			index: 3,
		},
		te_scco_sid: {
			value: "te_scco_sid",
			visible: false,
			index: 2,
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
		url: "http://localhost:8080/geoserver/all4land/wms",
		crossOrigin: "annonymous",
		params: {
			LAYERS: getLayers(),
			VERSION: "1.1.0",
		},
	});

	const wmsLayer = new ol.layer.Image({
		source: wmsSource,
	});

	// view object
	const view = new ol.View({
		center: initPosition,
		zoom: 8,
		projection: projection,
	});

	var LAYERS = [baseLyr1, wmsLayer];

	// Map object
	const map = new ol.Map({
		target: "map",
		view: view,
		layers: LAYERS,
	});

	const checkBoxElements = document.querySelectorAll("input[type=checkbox]");

	for (let checkBoxElement of checkBoxElements) {
		checkBoxElement.addEventListener("change", function(event) {

			let checkLayer;

			if (event.target.value == "te_scco_sgg_ln") {
				checkLayer = wmslist["te_scco_sgg_ln"];
			} else if (event.target.value == "te_scco_sid") {
				checkLayer = wmslist["te_scco_sid"];
			}

			if (checkLayer) {
				checkLayer.visible = this.checked;

				wmsLayer.getSource().updateParams({
					LAYERS: getLayers(),
				});

				if (getLayers().length === 0) {
					wmsLayer.setVisible(false);
				} else {
					wmsLayer.setVisible(true);
				}
			}




			// 체크 하나만 하도록
			if ($('#property').is(':checked') && $('#saveC').is(':checked')) {
				alert('둘 중 하나만 체크 바람');
				if (event.target.checked) {
					event.target.checked = false;
				} else {
					event.target.checked = true;
				}
				return;
			}

			// 조회 먼저 하고 동작 되도록
			if (event.target.id == 'property') {
				if (event.target.checked == false) {
					$('.attrDiv').css('display', 'none');
				} else if (wmslist['te_scco_sid'].visible) {
					$('.attrDiv').css('display', 'block');
				} else {
					alert(' te_scco_sid wms 조회 먼저')
					event.target.checked = false;
				} return;
			} else if (event.target.id == 'saveC') {
				$('.attrDiv').css('display', 'none');
				return;
			} else {
				$('.attrDiv').css('display', 'none');
			}
		});
	}


	// 지도 클릭 이벤트 추가
	const propertyToggle = document.querySelector('#property');
	let clickCallback = null;

	propertyToggle.addEventListener('change', () => {
		if (propertyToggle.checked) {
			clickCallback = function(evt) {
				var viewResolution = map.getView().getResolution();
				var url = wmsSource.getFeatureInfoUrl(
					evt.coordinate, viewResolution, 'EPSG:5179',
					{ 'INFO_FORMAT': 'application/json', 'propertyName': 'sid_cd,kor_sid_nm,eng_sid_nm' }
				);

				$.ajax({
					url: url,
					success: function(data) {
						if (data.features.length > 0) {
							var properties = data.features[0].properties;
							var sid_cd = properties.sid_cd;
							var kor_sid_nm = properties.kor_sid_nm;
							var eng_sid_nm = properties.eng_sid_nm;

							alert('sid_cd: ' + sid_cd + '\n'
								+ 'kor_sid_nm: ' + kor_sid_nm + '\n'
								+ 'eng_sid_nm: ' + eng_sid_nm);

							$('#sid_cd').val(sid_cd);
							$('#kor_sid_nm').val(kor_sid_nm);
							$('#eng_sid_nm').val(eng_sid_nm);

						} else {
							console.log('No feature clicked.');
						}
					}
				});
			};
			map.on('singleclick', clickCallback);
		} else {
			map.un('singleclick', clickCallback);
			clickCallback = null;
		}
	});


	// postgis 저장
	const coordinateToggle = document.querySelector('#saveC');

	coordinateToggle.addEventListener('change', () => {
		if (coordinateToggle.checked) {
			clickCallback = function(evt) {
				// 클릭한 위치의 좌표 알아내기
				var coord = evt.coordinate;

				// 서버로 보낼 데이터
				var data = {
					x: coord[0],
					y: coord[1]
				};

				// Ajax 요청 보내기
				$.ajax({
					url: '/save-coordinate', // 저장할 데이터를 처리할 서버 스크립트 경로
					type: 'POST', // 데이터 전송 방식
					data: data, // 서버로 보낼 데이터
					success: function(response) {
						alert('저장되었습니다.');
					},
					error: function(xhr, status, error) {
						alert('저장에 실패하였습니다.');
					}
				});
			};

			map.on('click', clickCallback);
		} else {
			map.un('click', clickCallback);
		}
	});






	// 저장된 좌표 보기


	// 캡쳐
	$('#capture').click(() => {
		map.once('rendercomplete', (e) => {
			const canvas = e.target.getViewport().querySelector('canvas');
			const mapContext = canvas.getContext('2d');

			if ($('.attrDiv').css('display') == 'block') {
				const attrDiv = document.querySelector('.attrDiv');
				html2canvas(attrDiv).then((attrDivCanvas) => {
					mapContext.drawImage(attrDivCanvas,  10, 1);
					mapContext.canvas.toBlob((blob) => {
						saveAs(blob, 'map1.png')
					});
				});
			} else {
				canvas.toBlob((blob) => {
					saveAs(blob, 'map.png')
				})
			}
		});
		map.renderSync();
	});


}