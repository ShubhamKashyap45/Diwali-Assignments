import React, { useEffect, useState } from "react";

const Todos = () => {
  const [todos, setTodos] = useState([]);
  const [loading, setLoading] = useState(true);

  // Fetch data from API
  useEffect(() => {
    fetch("https://jsonplaceholder.typicode.com/todos")
      .then((response) => response.json())
      .then((data) => {
        setTodos(data);
        setLoading(false);
      })
      .catch((error) => {
        console.error("Error fetching data:", error);
        setLoading(false);
      });
  }, []);

  if (loading) return <h2 style={{ textAlign: "center" }}>Loading...</h2>;

  return (
    <div style={{ width: "80%", margin: "30px auto", fontFamily: "Arial" }}>
      <h1 style={{ textAlign: "center" }}>Todo List</h1>
      <div
        style={{
          display: "grid",
          gridTemplateColumns: "repeat(auto-fit, minmax(250px, 1fr))",
          gap: "15px",
        }}
      >
        {todos.map((todo) => (
          <div
            key={todo.id}
            style={{
              border: "1px solid #ccc",
              borderRadius: "8px",
              padding: "15px",
              backgroundColor: todo.completed ? "#d4edda" : "#f8d7da",
              boxShadow: "0 2px 5px rgba(0,0,0,0.1)",
            }}
          >
            <h3 style={{ fontSize: "1rem" }}>ID: {todo.id}</h3>
            <p style={{ margin: "8px 0" }}>{todo.title}</p>
            <p>
              <strong>Status:</strong>{" "}
              {todo.completed ? "✅ Completed" : "❌ Not Completed"}
            </p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Todos;
