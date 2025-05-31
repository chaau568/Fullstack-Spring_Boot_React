import { useState } from 'react'
import './App.css'

function App() {
  const [name, setName] = useState('')
  const [msg, setMsg] = useState('')

  const handleFetch = () => {
  if (name.trim() === '') return;
  fetch(`http://localhost:8080/todo/hello/${name}`)
    .then(res => res.text())
    .then(data => setMsg(data))
    .catch(error => console.error("Error fetching:", error))
  }

  return (
    <>
      <h1>Here is frontend</h1>
      <input
      type='text'
      value={name}
      onChange={e => setName(e.target.value)}
      placeholder="Enter your name"
      />
      <button onClick={handleFetch}>Send</button>
      <h1>{msg}</h1>
    </>
  )
}

export default App
