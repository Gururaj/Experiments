from flask import Flask

app = Flask(__name__)

# app.debug = True

@app.route("/")
def root():
    return "<b>Root</b>"

@app.route("/hello")
def hello():
    return "<b>Hello World</b>"


def start():
    app.run()
    # app.run(host='0.0.0.0')
