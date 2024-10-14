document.addEventListener("DOMContentLoaded", function () {
    const navClicks = document.querySelectorAll("#nav li a");
    const currentPath = window.location.pathname;

    navClicks.forEach(link => {
        if (link.href.endsWith(currentPath)) {
            link.parentElement.classList.add("current");
        }
    });
});