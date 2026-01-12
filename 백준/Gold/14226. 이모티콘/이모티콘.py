import sys

input = sys.stdin.readline

N = int(input())

from collections import deque 

# 화면, 클립보드, 시간 
q = deque([ (1, 0, 0) ])

visited = { (1,0) : 0}
answer = N

while q: 
    screen, board, count = q.popleft() 
    # print(f"screen: {screen} board: {board} count: {count} q: {q}")
    if screen > 1000 or screen < 1:
        continue
    
    if screen == N: 
        answer = min(answer, count)
    elif screen > N: 
        if ((screen-1, board)) not in visited or visited[(screen-1, board)] > count + 1: 
            q.append((screen-1, board, count+1))
            visited[(screen-1, board)] = count + 1
    else: 
        if ((screen - 1, board)) not in visited or visited[
            (screen - 1, board)
        ] > count + 1:
            q.append((screen - 1, board, count + 1))
            visited[(screen - 1, board)] = count + 1
            
        if ((screen, screen) not in visited or visited[(screen, screen)] > count + 1 ) and screen != board: 
            q.append((screen, screen, count + 1))
            visited[(screen, screen)] = count + 1
    
        if ((screen+board, screen)) not in visited or visited[(screen, board)] > count + 1: 
            q.append((screen+board, board, count+1))
            visited[(screen+board, board)] = count + 1
    # 복사하거나 
    # 붙여넣기 하거나
    # 삭제하거나 
    
    
    
    
    
    
        
        
        
    

# print(f"answer: {answer}")

print(answer)
            
            
        
    


