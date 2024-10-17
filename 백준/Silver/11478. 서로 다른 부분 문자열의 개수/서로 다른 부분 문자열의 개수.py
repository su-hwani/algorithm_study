import sys
input = sys.stdin.readline

word = input()

word_len = 0

answer = set()
while True:
    for i in range(0, len(word) - word_len):
        answer.add(word[i:i +word_len])
    word_len += 1
    
    if word_len == len(word):
        break 
print(len(answer)-1)

# ababc