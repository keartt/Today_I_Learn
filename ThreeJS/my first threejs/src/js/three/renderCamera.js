import * as THREE from 'three';
import { OrbitControls } from '/jsm/controls/OrbitControls.js'; 

export { renderer, scene, camera };

// 렌더러 생성
const renderer = new THREE.WebGLRenderer({
    canvas : document.querySelector('#canvas')
  });
  renderer.setClearColor('#A9E2F3'); // 연한 하늘색 배경 (RGB 값)
  document.body.appendChild(renderer.domElement);

  // 씬과 카메라 생성
const scene = new THREE.Scene();
const camera = new THREE.PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000);
camera.position.set(-14.3, 8.98, 32.79); // 카메라의 위치 설정
// camera.lookAt(200, 0, 0); // 시야 설정
camera.zoom = 2; // 2배 확대7

// CubeTexture 로드
const textureLoader = new THREE.CubeTextureLoader();
const texture = textureLoader.load([
  '/img/4.png',  // 오른쪽
  '/img/2.png',  // 왼쪽
  '/img/1.png',  // 위
  '/img/6.png',  // 아래
  '/img/3.png',  // 뒤
  '/img/5.png'   // 앞
]);

// CubeTexture로 환경 매핑 생성
scene.background = texture;

// 조명 추가
const ambientLight = new THREE.AmbientLight(0xFFFFFF);
scene.add(ambientLight);

const directionalLight = new THREE.DirectionalLight(0xFFFFFF, 1);
directionalLight.position.set(1, 1, 1); // 조명의 위치 설정
scene.add(directionalLight);

// OrbitControls를 추가하고 활성화
const controls = new OrbitControls(camera, renderer.domElement);
controls.update();

function onWindowResize() {
  const newWidth = window.innerWidth;
  const newHeight = window.innerHeight;
  camera.aspect = newWidth / newHeight;
  camera.updateProjectionMatrix();
  // Three.js 렌더러의 크기 업데이트
  renderer.setSize(newWidth, newHeight);
}
// 창 크기 조정을 처리하는 이벤트 리스너 추가
window.addEventListener('resize', onWindowResize);
onWindowResize();


// 이전 카메라 위치를 저장할 변수
let previousCameraPosition = new THREE.Vector3();
// 렌더 루프를 사용하여 카메라 위치 출력
function logCameraPositionOnRender() {
  // 카메라의 위치 출력 함수
  function logCameraPosition() {
    const cameraPosition = camera.position;
    if (!cameraPosition.equals(previousCameraPosition)) {
      console.log(`camera.position.set(${cameraPosition.x.toFixed(2)}, ${cameraPosition.y.toFixed(2)}, ${cameraPosition.z.toFixed(2)} );`);
      previousCameraPosition.copy(cameraPosition);
    }
  }
  // 렌더링 루프
  function render() {
    logCameraPosition();
    renderer.render(scene, camera);
    requestAnimationFrame(render);
  }
  // 초기 카메라 위치 설정
  previousCameraPosition.copy(camera.position);
  // 렌더링 루프 시작
  render();
}

// logCameraPositionOnRender();