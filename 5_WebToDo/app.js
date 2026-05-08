const input = document.getElementById('todo-input');
const addBtn = document.getElementById('add-btn');
const list = document.getElementById('todo-list');

addBtn.addEventListener('click', () => {
    const text = input.value.trim();
    if (text === "") return;

    addTodo(text);
    saveTodos();
    input.value = '';
});

function saveTodos() {
    const items = [];
    document.querySelectorAll('#todo-list li').forEach(li => {
        const text = li.querySelector('span').textContent;
        const done = li.querySelector('span').classList.contains('done');
        items.push({ text, done});
    });
    localStorage.setItem('todos', JSON.stringify(items))
}

function loadTodos() {
    const data = localStorage.getItem('todos');
    if (!data) return;

    const items = JSON.parse(data);
    items.forEach(item => {
        addTodo(item.text, item.done)
    })
}

function addTodo(text, done = false) {
    const li = document.createElement('li');
    const span = document.createElement('span');

    li.className = 'list-group-item d-flex justify-content-between align-items-center fade-in'
    span.textContent = text;
    if (done) span.classList.toggle('done');
    span.addEventListener('click', () => {
        span.classList.toggle('done');
        if (span.classList.contains('done')) {
            span.classList.add('text-muted')
        } else {
            span.classList.remove('text-muted')
        }
        saveTodos();
    })
    
    const delBtn = document.createElement('button');
    delBtn.textContent = 'x';
    delBtn.className = 'delete-btn btn btn-outline-danger btn-sm ms-2';
    delBtn.innerHTML = '<i class="bi bi-trash"></i>'

    delBtn.addEventListener('click', () => {
        li.classList.add("fade-out");
        setTimeout(() => {
            li.remove();
            saveTodos();
        }, 300);
    });

    li.appendChild(span);
    li.appendChild(delBtn);
    list.appendChild(li);
}

loadTodos();