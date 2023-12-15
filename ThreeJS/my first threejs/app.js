const express = require('express');
const app = express();
const path = require('path')
const requestIp = require('request-ip');

const port = 3003;

// 정적 파일 (HTML, CSS, 이미지 등)을 제공하기 위해 "public" 디렉토리를 사용
app.use(express.static('src'));
app.use(
    '/build/',
    express.static(path.join(
        __dirname,
        'node_modules/three/build'
    ))
)
app.use(
    '/jsm/',
    express.static(path.join(
        __dirname,
        'node_modules/three/examples/jsm'
    ))
)

// 루트 경로에 접근할 때 index.html 파일을 제공
app.get('/', (req, res) => {
    console.log("client IP: " +requestIp.getClientIp(req));
    res.sendFile(__dirname + '/src/index.html');
});

app.get('/gasan', (req, res) => {
    console.log("client IP: " +requestIp.getClientIp(req));
    res.sendFile(__dirname + '/src/gasan.html');
});

app.listen(port, () => {
    console.log(`:${port} server 온!`);
});
