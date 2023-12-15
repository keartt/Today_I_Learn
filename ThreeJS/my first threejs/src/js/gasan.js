import * as THREE from 'three';
import { OrbitControls } from '/jsm/controls/OrbitControls.js'; 
import { GLTFLoader } from '/jsm/loaders/GLTFLoader.js';

// 장면 생성
let scene = new THREE.Scene();

// 카메라 생성
let camera = new THREE.PerspectiveCamera(
	50,
	window.innerWidth / window.innerHeight,
	1,
	10000
);
camera.position.set(-40, -2, 82);

scene.add(camera);
window.camera = camera;

// 렌더러
const renderer = new THREE.WebGLRenderer({
    canvas : document.querySelector('#canvas')
});
renderer.setSize(window.innerWidth, window.innerHeight);
document.body.appendChild(renderer.domElement);

// OrbitControls를 추가하고 활성화
const controls = new OrbitControls(camera, renderer.domElement);
controls.update();

// 구 생성
(function () {
    let textureLoader = new THREE.TextureLoader();
	let map = textureLoader.load("/img/Street360Gasan.jpg"); // 이미지 로딩 방식 수정
	let geometry = new THREE.SphereGeometry(2000, 64, 64);
	let material = new THREE.MeshBasicMaterial({
		map: map,
		side: THREE.BackSide,
	});
	let sphere = new THREE.Mesh(geometry, material);
	scene.add(sphere);
})();

const loader = new GLTFLoader();

let cowModel;
let cowMixer;
// 모델 로딩 및 애니메이션 설정
loader.load('./glb/cow.glb', (gltf) => {
    cowModel = gltf.scene;
    cowModel.scale.set(6000, 6000, 6000);
    scene.add(cowModel);
    cowModel.position.set(-0, 0, -0);
    cowMixer = new THREE.AnimationMixer(cowModel);
    console.log(gltf.animations)
    const walkAction = cowMixer.clipAction(gltf.animations[47]);
    walkAction.play();
});

let chickenModel;
let chickenMixer;
// 모델 로딩 및 애니메이션 설정
loader.load('./glb/chicken.glb', (gltf) => {
    chickenModel = gltf.scene;
    chickenModel.scale.set(20, 20, 20);
    scene.add(chickenModel);
    chickenModel.position.set(-100, -10, -10);
    chickenMixer = new THREE.AnimationMixer(chickenModel);
    console.log(gltf.animations)
    const walkAction = chickenMixer.clipAction(gltf.animations[2]);
    walkAction.play();
});




// 라이트
const color = 0xffffff;
const intensity = 1;
const light = new THREE.DirectionalLight(color, intensity);
light.position.set(-1, 2, 4);
camera.add(light);

// 애니메이션 업데이트 함수 추가
function animate() {
    requestAnimationFrame(animate);
    // 애니메이션 업데이트
    cowMixer.update(0.05); // 시간 간격 조절
    chickenMixer.update(0.05)
    renderer.render(scene, camera);
}

// set animate
animate();