result = []
words = ["A", "E", "I", "O", "U"]

def get(cur_word):
    global result, words
    
    if len(cur_word) == 5: 
        return 
    
    for i in words:
        result.append(cur_word+i)
        get(cur_word + i)
        
        
def solution(word):
    global result 
    answer = 0
    get("")
    for i in range(0, len(result)):
        if str(word) == str(result[i]):
            answer = i
    
    return answer+1