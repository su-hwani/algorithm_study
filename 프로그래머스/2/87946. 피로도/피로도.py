from itertools import permutations

def get_score(score, minimum, using, count):
    if score >= minimum:
        score -= using
        count += 1
    return score, count
    

def solution(k, dungeons):
    dungeons_permu = list(permutations(dungeons))
    answer = 0
    
    for i in dungeons_permu:
        score = k
        count = 0
        
        for j in i:
            minimum, using = j[0], j[1]
            score, count = get_score(score, minimum, using, count)
        if count > answer:
            answer = count
            
    return answer