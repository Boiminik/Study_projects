# app.py in Visual Studio Code

from flask import Flask

app = Flask(__name__)

@app.route('/store')
def store():

    r = requests.get('http://localhost:8080/sales')

    sales = r.json()

    number_of_sales = len(sales)

    return '<h2> Currently there are ' + number_of_sales + ' sales!</h2>'
   ## return sales.text 
   ## return r.text
   ## return '<h1>Store</h1>'