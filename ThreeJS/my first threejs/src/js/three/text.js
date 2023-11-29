import * as THREE from 'three';
import { TextGeometry } from '/jsm/geometries/TextGeometry.js';
import { FontLoader } from '/jsm/loaders/FontLoader.js';
import { scene } from './renderCamera.js';

// 텍스트 폰트 로드
const fontLoader = new FontLoader();
fontLoader.load('/etc/font/Nanum_AmS.json', (font) => {
  const textGeometry = new TextGeometry('치킨', {
    font: font,
    size: 1, // 텍스트 크기
    height: 0.1, // 높이
  });
  
  const textMaterial = new THREE.MeshBasicMaterial({ color: 0xFF1493 }); // 텍스트 색상
  
  const textMesh = new THREE.Mesh(textGeometry, textMaterial);
  textMesh.position.set(-42, 3, 0);

  scene.add(textMesh);
});

fontLoader.load('/etc/font/Nanum_AmS.json', (font) => {
  const textGeometry = new TextGeometry('육회', {
    font: font,
    size: 1, // 텍스트 크기
    height: 0.1, // 높이
  });
  
  const textMaterial = new THREE.MeshBasicMaterial({ color: 0x4682B4 }); // 텍스트 색상
  
  const textMesh = new THREE.Mesh(textGeometry, textMaterial);
  textMesh.position.set(-37, 3, 0);

  scene.add(textMesh);
});