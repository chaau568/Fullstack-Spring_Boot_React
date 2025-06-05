// App.jsx
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom'
import './App.css'
import Hello from './hello/Hello'

function App() {
  return (
    <Router>
      <nav>
        <Link to="/">Home</Link>
        <Link to="/hello">Hello</Link>
      </nav>
      <Routes>
        <Route path="/" element={<h1>Welcome Home</h1>} />
        <Route path="/hello" element={<Hello />} />
      </Routes>
    </Router>
  )
}

export default App
