const express = require("express");
const bodyParser = require("body-parser");
const mysql = require("mysql2");
const app = express();

// Middleware
app.use(bodyParser.urlencoded({ extended: false }));
app.use(express.static(__dirname)); // Serve HTML file

// MySQL Connection
const db = mysql.createConnection({
  host: "localhost",
  user: "root", // <-- replace with your MySQL username
  password: "", // <-- replace with your MySQL password
  database: "userdb",
});

db.connect((err) => {
  if (err) {
    console.error("Database connection failed:", err);
  } else {
    console.log("Connected to MySQL database.");
  }
});

// Route to serve the registration form
app.get("/", (req, res) => {
  res.sendFile(__dirname + "/index.html");
});

// Route to handle form submission
app.post("/register", (req, res) => {
  const { full_name, email, username, password } = req.body;

  const sql =
    "INSERT INTO users (full_name, email, username, password) VALUES (?, ?, ?, ?)";
  db.query(sql, [full_name, email, username, password], (err, result) => {
    if (err) {
      console.error("Error inserting data:", err);
      res.send("❌ Registration failed. Please try again.");
    } else {
      res.send("✅ User registered successfully!");
    }
  });
});

// Start server
const PORT = 3000;
app.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}`);
});
