const prevBtns = document.querySelectorAll(".btn-prev");
const nextBtns = document.querySelectorAll(".btn-next");
const clearBtns = document.querySelectorAll(".btn-clear");
const submitBtns = document.querySelectorAll(".btn-submit");
const progress = document.getElementById("progress");
const formSteps = document.querySelectorAll(".form-box");
const progressSteps = document.querySelectorAll(".progress-step");

let formStepsNum = 0;

// Next button
nextBtns.forEach((btn) => {
  btn.addEventListener("click", () => {
    formStepsNum++;
    updateFormSteps();
    updateProgressbar();
  });
});

// Previous button 
prevBtns.forEach((btn) => {
  btn.addEventListener("click", () => {
    formStepsNum--;
    updateFormSteps();
    updateProgressbar();
  });
});

// Clear button 
clearBtns.forEach((btn) => {
  btn.addEventListener("click", () => {
    clearCurrentSection();
  });
});

// Submit button 
submitBtns.forEach((btn) => {
  btn.addEventListener("click", () => {
    alert("Form submitted successfully!");
    // Add form submission logic here
  });
});

function updateFormSteps() {
  // Toggle active form step
  formSteps.forEach((formStep) => {
    formStep.classList.remove("form-box-active");
  });

  formSteps[formStepsNum].classList.add("form-box-active");

  toggleSubmitButton();
}

function updateProgressbar() {
  progressSteps.forEach((progressStep, idx) => {
    if (idx < formStepsNum + 1) {
      progressStep.classList.add("progress-step-active");
    } else {
      progressStep.classList.remove("progress-step-active");
    }
  });

  const progressActive = document.querySelectorAll(".progress-step-active");
  progress.style.width =
    ((progressActive.length - 1) / (progressSteps.length - 1)) * 100 + "%";
}

function clearCurrentSection() {
  const currentSection = formSteps[formStepsNum];
  const inputs = currentSection.querySelectorAll(".input-field");
  const checkboxes = currentSection.querySelectorAll("input[type='checkbox']");

  inputs.forEach((input) => {
    input.value = "";
  });

  checkboxes.forEach((checkbox) => {
    checkbox.checked = false;
  });
}

function toggleSubmitButton() {
  const lastPage = formStepsNum === formSteps.length - 1;

  submitBtns.forEach((btn) => {
    btn.style.display = lastPage ? "inline-block" : "none";
  });

  clearBtns.forEach((btn) => {
    btn.style.justifyContent = lastPage ? "flex-start" : "flex-end";
  });
}


// Get radio buttons and the corresponding sections
const bandRadio = document.getElementById("band");
const individualRadio = document.getElementById("individual");
const bandBox = document.querySelector(".band-box");
const indBox = document.querySelector(".ind-box");

// Function to toggle visibility based on selection
function toggleSections() {
    if (bandRadio.checked) {
        bandBox.style.display = "block"; // Show band section
        indBox.style.display = "none";  // Hide individual section
    } else if (individualRadio.checked) {
        indBox.style.display = "block"; // Show individual section
        bandBox.style.display = "none";  // Hide band section
    }
}

// Event listeners for radio buttons
bandRadio.addEventListener("change", toggleSections);
individualRadio.addEventListener("change", toggleSections);

// Initial visibility setup
toggleSections(); // Call the function once to set the initial state


