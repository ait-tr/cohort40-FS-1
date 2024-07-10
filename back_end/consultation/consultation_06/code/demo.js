fetch('/api/managers')
.then(response => response.json())
.then(data => console.log(data));

fetch('/api/managers', {
    method: 'POST',
    header: {
        'Content-Type':'application/json'
    },
    body: JSON.stringify({key: 'value'})

    }
)
.then(response => response.text())
.then(data => console.log(data))