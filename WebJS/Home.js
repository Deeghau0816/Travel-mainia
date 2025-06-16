//Image slider

const slidesContainer = document.querySelector(".slides-container");
const totalSlides = document.querySelectorAll(".slide").length;
let slideIndex = 0;
let intervalId = null;

document.addEventListener("DOMContentLoaded", () => {
    updateSlidePosition();
    intervalId = setInterval(nextSlide, 5000);
    
    // Pause on hover
    document.querySelector(".slider").addEventListener("mouseenter", () => clearInterval(intervalId));
    document.querySelector(".slider").addEventListener("mouseleave", () => intervalId = setInterval(nextSlide, 5000));
});

// Update slide position
function updateSlidePosition() {
    slidesContainer.style.transform = `translateX(-${slideIndex * 100}%)`;
}

function prevSlide() {
    slideIndex = (slideIndex - 1 + totalSlides) % totalSlides;
    updateSlidePosition();
    resetInterval();
}

function nextSlide() {
    slideIndex = (slideIndex + 1) % totalSlides;
    updateSlidePosition();
    resetInterval();
}

//After leaving curser
function resetInterval() {
    clearInterval(intervalId);
    intervalId = setInterval(nextSlide, 5000);
}
