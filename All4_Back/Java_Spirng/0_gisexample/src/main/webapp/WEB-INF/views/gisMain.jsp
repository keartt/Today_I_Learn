<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
    <html>
    <head>
    <meta charset="utf-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet"
            href="https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v6.9.0/css/ol.css" type="text/css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/proj4js/2.8.0/proj4.js"></script>
        <script
            src="https://cdn.polyfill.io/v3/polyfill.min.js?features=fetch,requestAnimationFrame,Element.prototype.classList,TextDecoder">
        </script>
        <script src="https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v6.9.0/build/ol.js"></script>
        <script src="https://html2canvas.hertzen.com/dist/html2canvas.min.js"></script>
        <script src="<%=request.getContextPath()%>/resources/static/js/FileSaver.min.js"></script>
		<script src="<%=request.getContextPath()%>/resources/static/js/emap.js"></script>
		
		
    <title>WMTS example</title>

            <style>
                    html,
                    body {
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
                    <h2>레이어</h2>
                    <div>
                        <div>
                            <input type="checkbox" name="wmsLayerCheckbox1" value="te_scco_sid_wms" id="te_scco_sid_wms" />
                                <label for="te_scco_sid_wms">te_scco_sid_wms 조회</label>
                        </div>
                        <div>
                            <input type="checkbox" name="wmsLayerCheckbox2" value="te_scco_sgg_ln_wms" id="te_scco_sgg_ln_wms" />
                                <label for="te_scco_sgg_ln_wms">te_scco_sgg_ln_wms 조회</label>
                        </div>
                        <div>
                            <input type="checkbox" name="attSearch" id="attSearch" />
                                <label for="attSearch">te_scco_sid 속성 조회</label>
                        </div>
                        <div>
                            <input type="checkbox" name="regTarget" id="regTarget" />
                                <label for="regTarget">좌표등록</label>
                        </div>
                        <div>
                            <button type="button" name="regTargetSearch" value="regTargetSearch" id="regTargetSearch">등록좌표조회</button>
                        </div>
                        <div>
                            <button type="button" name="saveMap" value="saveMap" id="saveMap">화면저장</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="grid-3">
                <div id="map"></div>
            </div>
            <div class="attrDiv">
                <div>시도 코드 : <input type="text" id="sid_cd" readonly></div>
                <div>한글 시도 명 : <input type="text" id="kor_sid_nm" readonly></div>
                <div>영문 시도 명 : <input type="text" id="eng_sid_nm" readonly></div>
            </div>
		</div>

    </body>
</html>