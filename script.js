const backToTop = document.querySelector(".back-to-top");

backToTop.addEventListener('click', () => {
	window.scrollTo(0, 0)
})

let galleryLeft = 0;
let disableRight = 1;
let disableleft = 0;
const windowInnerWidth = window.innerWidth;
// const width = 


// const onLeft = () => {
// 	if (galleryLeft < 0) {
// 		galleryLeft += 100;
// 		disableRight = 0;
// 	}
// 	else {
// 		disableleft = 1;
// 	}
// }
// const onRight = () => {
// 	if(+windowInnerWidth - left < )
// }