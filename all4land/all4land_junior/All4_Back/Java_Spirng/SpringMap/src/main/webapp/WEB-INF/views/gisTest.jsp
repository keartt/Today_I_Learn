<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v6.9.0/css/ol.css"
	type="text/css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/proj4js/2.8.0/proj4.js"></script>
<script
	src="https://cdn.polyfill.io/v3/polyfill.min.js?features=fetch,requestAnimationFrame,Element.prototype.classList,TextDecoder">
	
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v6.9.0/build/ol.js"></script>
	 <script src="https://html2canvas.hertzen.com/dist/html2canvas.min.js"></script>
	 <script src="https://cdn.jsdelivr.net/npm/file-saver@2.0.5/dist/FileSaver.min.js"></script>
	 
		<script src="<%=request.getContextPath()%>/resources/static/js/gisTest.js"></script>


<title>gis Test</title>

<style>
html, body {
font-size: 16px;
	width: 100%;
	height: 100%;
	margin: 0;
	padding: 0;
}

#map {
	height: 100%;
	width: 100%;
}

.grid-container {
	padding-left: 1%;
	display: grid;
	grid-template-columns: 20vw 80vw;
	grid-template-rows: 100vh;
}

.sidebar {
	position: absolute;
}

.onoff-switch-container {
	position: relative;
	margin:10px;
}

.onoff-switch-container input[type="checkbox"] {
	position: absolute;
	width: 0px;
	height: 0px;
	overflow: hidden;
}

.onoff-switch-container label {
	padding-left: 70px;
	line-height: 30px;
	font-size: 16px;
}

.onoff-switch-container label::after {
	position: absolute;
	top: 3px;
	left: 4px;
	content: '';
	width: 24px;
	height: 24px;
	background: #d1d1d1;
	border-radius: 100%;
	transition: all 0.3s
}

.onoff-switch-container label::before {
	position: absolute;
	top: 0;
	left: 0;
	content: '';
	width: 60px;
	height: 30px;
	border: 1px solid #d1d1d1;
	border-radius: 20px;
	background: #f1f1f1;
	box-sizing: border-box;
}

.onoff-switch-container input[type="checkbox"]:checked+label::after {
	transform: translateX(28px);
	background: rgb(32, 158, 61);
}

.onoff-switch-container input[type="checkbox"]:checked+label::before {
	background: #fff;
}

.attrDiv {
             			display: none;
    					position: absolute;
    					background: white;
    					top: 50%;
    					left: 50%;
    					border: solid red;
                    }
</style>

</head>
<body>
	<div class="grid-container">
		<div class="grid-1">
			<div class="sidebar">
				<h2 style="margin :20px;">레이어</h2>
				<div>

					<div class="onoff-switch-container">
						<input type="checkbox" name="wms" value="te_scco_sgg_ln" id="te_scco_sgg_ln" /> <label
							for="te_scco_sgg_ln">te_scco_sgg_ln wms 조회하기</label><br>
					</div>
					
					
					<div class="onoff-switch-container">
						<input type="checkbox" name="wms" id="te_scco_sid" value="te_scco_sid" /> <label
							for="te_scco_sid">te_scco_sid wms 조회하기</label><br>
					</div>
				

					<div class="onoff-switch-container">
						<input type="checkbox" name="property" id="property" /> <label
							for="property">좌표 선택 후 속성 조회</label><br>
					</div>

					<div class="onoff-switch-container">
						<input type="checkbox" name="saveC" id="saveC" /> <label
							for="saveC">좌표 선택 후 db 저장</label>
					</div>
					<div>
					<button type="button" class="btn btn-success" name="viewC" id="viewC"  >등록 좌표 조회</button>
					<button type="button" class="btn btn-primary" name="capture" id="capture"  >현재 화면 저장</button>
					</div>
				</div>
			</div>
		</div>
		<div class="grid-3">
			<div id="map"></div>
		</div>
		<div class="attrDiv" >
			<div>시도 코드 : <input type ="text" id = "sid_cd" readonly></div>
			<div>한글 시도 : <input type ="text" id = "kor_sid_nm" readonly></div>
			<div>영문 시도 : <input type ="text" id = "eng_sid_nm" readonly></div>
		</div>
	</div>

</body>
</html>