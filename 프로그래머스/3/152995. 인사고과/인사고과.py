def solution(scores):
    main_score = scores[0]
    
    scores.sort(key=lambda x: (-x[0], x[1]))
    live_scores = []
    
    max_b = 0
    
    for i in range(len(scores)): 
        if scores[i][1] < max_b:  # 탈락 조건
            if scores[i][0] == main_score[0] and scores[i][1] == main_score[1]: 
                return -1 
            continue
        
        live_scores.append(scores[i])
        max_b = max(scores[i][1], max_b)
    
    live_scores.sort(key=lambda x: -sum(x))
    
    answer = 0
    for i in range(len(live_scores)):
        if sum(live_scores[i]) == sum(main_score):
            answer = i + 1
            break
    
    return answer