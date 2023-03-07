<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
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
		<script src="${pageContext.request.contextPath}/resources/js/emap.js"></script>
		
		
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
             </style>

    </head>
    <body>
        <div class="grid-container">
            <div class="grid-1">
                <div class="sidebar">
                    <h2>레이어</h2>
                    <div>
                        <div>
                            <input type="checkbox" name="wmsLayerCheckbox" value="te_scco_sid_wms" id="te_scco_sid_wms" />
                                <label for="te_scco_sid_wms">te_scco_sid_wms</label>
                        </div>
                        <div>
                            <input type="checkbox" name="wfsLayerCheckbox" value="te_scco_sid_wfs" id="te_scco_sid_wfs" />
                                <label for="te_scco_sid_wfs">te_scco_sid_wfs</label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="grid-3">
                <div id="map"></div>
            </div>
            </div>

    </body>
</html>