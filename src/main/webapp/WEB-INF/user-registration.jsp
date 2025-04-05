<html>
<body>
  <h2>User Registration - Cab Order Management System</h2>

  <form action="/cab-order-app/user-controller" method="POST">
      <label for="name">User Name:</label>
      <input type="text" name="name" id="name" placeholder="Enter name" required><br><br>

      <label for="email">Email:</label>
      <input type="email" name="email" id="email" placeholder="Enter email" required><br><br>

      <label for="phone">Phone:</label>
      <input type="text" name="phone" id="phone" placeholder="Enter phone" required><br><br>

      <button type="submit">Register</button>
  </form>

  <br>
  <a href="index.jsp">Home</a>
</body>
</html>
