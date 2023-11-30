const http = require('http');
const mysql = require('mysql');
const url = require('url');

const hostname = '127.0.0.1';
const port = 8080;

var con = mysql.createConnection({ host: "localhost", database: "inet2005", user: "root", password: "mysql" });

const server = http.createServer((req, res) => {
    res.statusCode = 200;
    res.setHeader('Content-type', 'text/html');

    var params = url.parse(req.url, true);
    var search_term = params.query.firstName;

    var sql = "SELECT * FROM people WHERE firstName LIKE '" + search_term + "%';"
    
    con.query(sql, function (err, rows, fields) {
        if (err) throw err;

        var length = Object.keys(rows).length;

        let html = '<html>\n<head>\n<title>my page</title>\n</head>\n<body>';

        for (var i = 0; i < length; i++) {
                html += "<p>" + rows[i].firstName + " " + rows[i].lastName + "</p>";
        }
        html += '</body>\n</html>';

        res.write(html);
        res.end();
    });
});

server.listen(port, hostname, () => {
    const mysql = require('mysql');

    con.connect(function(err) {
    if (err) throw err;
        console.log("Connected!");
    });

    console.log(`Server started, goto http://${hostname}:${port}`);
});
