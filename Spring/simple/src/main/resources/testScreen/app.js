// screen share program by js with gpt

const shareScreenButton = document.getElementById('shareScreen');
const stopSharingButton = document.getElementById('stopSharing');
const videoElement = document.getElementById('screenVideo');
let screenStream;

// Start screen sharing
shareScreenButton.addEventListener('click', async () => {
    try {
        // Request screen capture
        screenStream = await navigator.mediaDevices.getDisplayMedia({
            video: {
                cursor: "always" // Always show the cursor
            },
            audio: false // Optionally share audio
        });

        // Show the screen stream in the video element
        videoElement.srcObject = screenStream;

        // Enable the stop sharing button
        stopSharingButton.disabled = false;
        shareScreenButton.disabled = true;

        const recorder = new MediaRecorder(screenStream);
        recorder.ondataavailable = function(event) {
            if (event.data.size > 0) {
                // Convert Blob to ArrayBuffer and send via WebSocket
                event.data.arrayBuffer().then(arrayBuffer => {
                    const array = new Uint8Array(arrayBuffer);
                    console.log('screen', array);
                });
            }
        };
        recorder.start(1000); // Send data every second


        // Handle the end of the screen share
        screenStream.getVideoTracks()[0].addEventListener('ended', () => {
            stopSharing();
        });
    } catch (err) {
        console.error("Error sharing screen:", err);
    }
});

// Stop screen sharing
stopSharingButton.addEventListener('click', () => {
    stopSharing();
});

function stopSharing() {
    if (screenStream) {
        // Stop all tracks to end the screen share
        screenStream.getTracks().forEach(track => track.stop());
        videoElement.srcObject = null;

        // Update the UI
        stopSharingButton.disabled = true;
        shareScreenButton.disabled = false;
    }
}
