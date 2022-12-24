const backToTop = document.querySelector(".back-to-top");
const gallery = document.querySelector(".section-4 .content .vibe_images .vibe_gallery_1");
const gallery2 = document.getElementsByClassName("vibe_gallery_1")[0];
const leftController = document.querySelector(".controllers .left");
const rightController = document.querySelector(".controllers .right");
backToTop.addEventListener('click', () => {
	window.scrollTo(0, 0)
})

leftController.addEventListener("click", () => moveLeft());

rightController.addEventListener("click", () => moveRight());

let galleryLeft = 0;
let disableRight = 0;
let disableleft = 1;
const galleryWidth = gallery.offsetWidth; 
const windowInnerWidth = window.innerWidth;

const moveLeft = () => {
	// console.log("moveleft");
	if (galleryLeft < 0) {
		// console.log("moving left...");
		// setLeft(left + +width);
		galleryLeft += 500;
		disableRight = 0;
	} else {
		// setDisableLeft(true);
		disableleft = 1;
	}
	// console.log(gallery.style);
	gallery2.style.marginLeft = `${galleryLeft}px`;
};
const moveRight = () => {
	// console.log("moveRight");
	// console.log(galleryWidth);
	if (-galleryLeft + windowInnerWidth < galleryWidth) {
		// console.log("moving right...");
		// console.log(left + windowInnerWidth, (+width + 20) * items.length);
		// setLeft(left - width);
		galleryLeft -= 500;
		// setDisableLeft(false);
		disableleft = 0;
	} else {
		// setDisableRight(true);
		disableRight = 1;
	}
	gallery2.style.marginLeft = `${galleryLeft}px`;
	// console.log(gallery2.style.marginLeft);
	// gallery.style.border = "2px solid red";
};