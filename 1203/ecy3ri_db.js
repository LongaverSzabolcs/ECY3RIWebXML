const STORAGE_KEY = 'ECY3RI_Json_DB'

function loadData() {
    const raw = localStorage.getItem();
    return raw ? JSON.parse(raw) : [];
}

function saveData(data) {
    localStorage.setItem(STORAGE_KEY, JSON.stringify(data));
}

function addItem() {
    const data = loadData();
}
