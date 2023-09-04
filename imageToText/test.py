import cv2
import pytesseract
import re

config = ('-l eng --oem 1 --psm 11')
pytesseract.pytesseract.tesseract_cmd = "/opt/homebrew/bin/tesseract"


imgs = ['./test3.jpeg', './test4.jpeg', './test5.jpeg']

for img in imgs:
    text = pytesseract.image_to_string(img, config=config)
    text = text.split('\n')
    for t in text:
        if re.search(r'\d\d?', t.lower()):
            if re.search(r'\sam\s|\spm\s', t.lower()):
                print("Time :" + t)
            else:
                print(t)

    print("----")
