from nsetools import Nse
from flask import Flask

app = Flask(__name__)

@app.route('/get/quote/<symbol>')
def getQuote(symbol):
     return Nse().get_quote(str(symbol))

if __name__ == '__main__':
    app.run(threaded=True)