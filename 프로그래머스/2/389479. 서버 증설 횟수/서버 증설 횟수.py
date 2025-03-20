
def solution(players, m, k):
    created_server = []
    answer = 0
    
    for i in range(len(players)):
        essential_server = players[i] // m
        
        can_server = 0
        for q in created_server:
            if q > i:
                can_server += 1
        
        if essential_server > can_server:
            essential_server -= can_server
            answer += essential_server
            for q in range(essential_server):
                created_server.append(i+k)
            
    return answer