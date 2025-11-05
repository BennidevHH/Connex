import React, {useEffect, useState} from 'react'
import Stomp from 'stompjs'
import SockJS from 'sockjs-client'

const backend = import.meta.env.VITE_BACKEND_URL || 'http://localhost:8080'

function App(){
  const [connected, setConnected] = useState(false)
  const [messages, setMessages] = useState<any[]>([])
  useEffect(() => {
    // Example connect flow: obtain token from localStorage, then connect via SockJS + STOMP with token in query
    const token = localStorage.getItem('token')
    const socket = new SockJS(`${backend}/ws?token=${token}`)
    const client = Stomp.over(socket as any)
    client.connect({}, () => {
      setConnected(true)
      client.subscribe('/topic/channel/general', (msg: any) => {
        setMessages(prev => [...prev, JSON.parse(msg.body)])
      })
    }, (err: any) => {
      console.error('STOMP error', err)
    })
    return () => { try{ client.disconnect(()=>{}) }catch(e){} }
  }, [])
  return (
    <div className="p-4">
      <h1 className="text-2xl font-bold">Connex - Frontend (Vite + React + TS)</h1>
      <p>Connected: {'' + connected}</p>
      <div className="mt-4">
        {messages.map((m, i) => <div key={i} className="border p-2 my-1 rounded">{m.content} <small className="text-xs">by {m.senderUsername}</small></div>)}
      </div>
    </div>
  )
}

export default App
