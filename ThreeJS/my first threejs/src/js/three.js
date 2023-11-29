import * as THREE from 'three';
import { renderer, scene, camera } from './three/renderCamera.js';
import { loaderAnimation } from './three/loader.js';
import { } from './three/text.js';

function animate() {
  loaderAnimation();
  
  requestAnimationFrame(animate);
  renderer.render(scene, camera);
}
animate();
