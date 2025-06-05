import { useState } from 'react'

function Hello() {
  const [msg, setMsg] = useState('')

  const handleFetch = () => {
    const input = document.getElementById('message').value;
    if (input.trim() === '') return;
    const data = {
      message : input
    }
    fetch('http://localhost:8080/todo/hello', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)
    })
      .then(res => res.json())
      .then(data => setMsg(data.message))
      .catch(error => console.error("Error fetching:", error))
  }

  return (
    <>
      <h1>Here is frontend</h1>
      <input id='message' type='text' placeholder="Enter your name" />
      <button onClick={handleFetch}>Send</button>
      <h1>{msg}</h1>
    </>
  )
}

export default Hello
