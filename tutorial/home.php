<?php
    session_start();
    echo $_SESSION['username'];
?>
<html>
    <style>
        html {
            scroll-behavior: smooth;
        }
    </style>
    <head>
        <script src="jq.js"></script>
        <script>
            setInterval(refresh, 1000);

            function refresh() {
                $("#logs").load('display.php');
            }
            function main() {
                var logs = $('#message').val();
                $.ajax({
                    type: "POST",
                    url: "post.php",
                    data: {logs},
                    succes:function () {
                        refresh();
                    }
                });
            }
            function main2() {
                document.getElementById("message").value = "";
            }
        </script>
    </head>
    <body>
        <a href="#bottom">Kattints rám</a>
        <div id="chat">
            <div id="logs"></div>
            <div id="form">
                <textarea id="message"></textarea>
                <button onclick="main(); main2()">Küld!</button>
            </div>
        </div>
        <a href="logout.php" id="bottom">Kijelentkezés!</a>
    </body>
</html>