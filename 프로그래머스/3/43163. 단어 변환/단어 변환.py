answer = 10**9

def dfs(cur_word, target, words, visited, count):
    global answer
    # print(f"cur_word: {cur_word}, target:{target}, visited:{visited}, count:{count}")
    if cur_word == target:
        if count <= answer:
            answer = count
        return 
    for i in range(len(words)):
        can = True
        c = 0
        for k in range(0, len(words[i])):
            if words[i][k] != cur_word[k]:
                c += 1
                if c == 2:
                    can = False
                    break
        if can and visited[i] is False:
            visited[i] = True
            dfs(words[i], target, words, visited, count+1)
            visited[i] = False
    return 

def solution(begin, target, words):
    global answer
    visited = [False for i in range(len(words))]
    
    dfs(begin, target, words,visited, 0)
    
    if answer == 10**9:
        return 0
    return answer