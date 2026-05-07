const input = document.getElementById("todo-input");
const addBtn = document.getElementById("add-btn");
const list = document.getElementById("todo-list");

addBtn.addEventListener("click", () => {
    const text = input.value.trim();
    if (text === "") return;

    const li = document.createElement("li");
    const span = document.createElement("span");
    const delBtn = document.createElement("button");

    span.textContent = text;

    delBtn.textContent = "✕";
    delBtn.className = "delete-btn";

    delBtn.addEventListener("click", () => {
        li.remove();
    })

    li.appendChild(span);
    li.appendChild(delBtn);
    list.appendChild(li);
    
    input.value = "";
});