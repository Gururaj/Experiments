
from Levenshtein import distance, hamming
import string

dis = distance("lewenstein", "levenshtein", weights=(2, 2, 1))
print(dis)
ham = hamming("lewenstein", "levenshtein")
print(ham)


words = ["january", "february", "march", "april", "may", "june",
         "july", "august", "september", "october", "november", "december"]

modified_words = []

lower = list(string.ascii_lowercase)

for word in words:
    for i in range(0, len(word)):
        for c in lower:
            new_word = word[:i] + c + word[i+1:]
            modified_words.append(new_word)

print(len(modified_words))


word = words[8]
for m_word in modified_words:
    ham = hamming(word, m_word)
    if (ham < 3):
        print(m_word + " " + word)
