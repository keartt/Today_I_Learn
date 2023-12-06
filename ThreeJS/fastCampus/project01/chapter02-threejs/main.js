import './style.css';
import * as THREE from 'three';

const scene = new THREE.Scene();
const camera = new THREE.PerspectiveCamera(
  60, //fov 시야각
  window.innerWidth / window.innerHeight,// 가로세로비율 aspect
  0.1,//리어각
  100//far
)
//
// z 앞뒤, x 좌우, y 상하
camera.position.z = 5; // camera != render position

//geometry
const geometry = new THREE.BoxGeometry(1, 1, 1);
//meterial
const material = new THREE.MeshBasicMaterial({ color: 0xff0000 });

const mesh = new THREE.Mesh(geometry, material);
scene.add(mesh);

const renderer = new THREE.WebGLRenderer();
renderer.setSize(window.innerWidth, window.innerHeight)
document.body.appendChild(renderer.domElement)
window.addEventListener('reseize', () => {
  // 윈도우 크기변경시 다시 render 크기변경 
  renderer.setSize(window.innerWidth, window.innerHeight)
  // camera 속성도 변경
  camera.updateProjectionMatrix(window.innerWidth / window.innerHeight)
  camera.updateProjectionMatrix();
})

renderer.render(scene, camera);