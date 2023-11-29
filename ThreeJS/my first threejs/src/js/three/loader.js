import * as THREE from 'three';
import { GLTFLoader } from '/jsm/loaders/GLTFLoader.js';
import { scene } from './renderCamera.js';

export {loaderAnimation };

// 모델 로딩 및 추가
const loader = new GLTFLoader();

loader.load('/glb/island.glb', (gltf) => {
    const model = gltf.scene;
    model.scale.set(3, 3, 3);
    model.position.set(0, -15, 0);
    scene.add(model);
});

let dragonModel;
let dragonMixer;
loader.load('/glb/cute_dragon.glb', (gltf) => {
    dragonModel = gltf.scene;
    dragonModel.scale.set(15, 15, 15);
    dragonModel.position.set(35, 11, -10);
    scene.add(dragonModel);

    dragonMixer = new THREE.AnimationMixer(dragonModel);
    const walkAction = dragonMixer.clipAction(gltf.animations[0]);
    walkAction.play();
});


loader.load('/glb/dog.glb', (gltf) => {
    const model = gltf.scene;
    scene.add(model);
    model.position.set(0, 4, -5); // 모델 2의 위치
});

let catModel;
let catMixer
loader.load('/glb/cat.glb', (gltf) => {
    catModel = gltf.scene;
    catModel.scale.set(0.005, 0.005, 0.005);
    scene.add(catModel);
    catModel.position.set(6, -6.4, 11); // 모델 3의 위치
    catModel.rotation.y = Math.PI * 3 / 2; // 90도를 라디안으로 표현 
    // AnimationMixer 생성
    catMixer = new THREE.AnimationMixer(catModel);

    // 애니메이션 액션을 추가하고 재생
    const walkAction = catMixer.clipAction(gltf.animations[0]);
    walkAction.play();   // 
});

let cowModel;
let cowMixer
loader.load('./glb/cow.glb', (gltf) => {
    cowModel = gltf.scene;
    cowModel.scale.set(250, 250, 250);
    scene.add(cowModel);
    cowModel.position.set(-35, 5, -3);
    cowMixer = new THREE.AnimationMixer(cowModel);

    const walkAction = cowMixer.clipAction(gltf.animations[0]);
    walkAction.play();   // 
});

let chickenModel;
let chickenMixer
loader.load('/glb/chicken.glb', (gltf) => {
    chickenModel = gltf.scene;
    chickenModel.scale.set(1, 1, 1);
    scene.add(chickenModel);
    chickenModel.position.set(-39, 3, -5);
    chickenMixer = new THREE.AnimationMixer(chickenModel);

    const walkAction = chickenMixer.clipAction(gltf.animations[0]);
    walkAction.play();   // 
});

function updateModelMixer(modelName, deltaTime) {
    const model = eval(modelName + 'Model');
    const mixer = eval(modelName + 'Mixer');
    if (model && mixer) {
        mixer.update(deltaTime); // 시간 업데이트
        // 원하는 위치로 모델을 이동
        // model.position.x += 0.01;
    }
}

function loaderAnimation() {
    updateModelMixer('cat', 0.01);
    updateModelMixer('dragon', 0.01);
    updateModelMixer('cow', 0.1);
    updateModelMixer('chicken', 0.1);
}
