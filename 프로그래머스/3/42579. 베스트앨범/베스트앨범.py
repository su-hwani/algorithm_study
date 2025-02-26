def solution(genres, plays):
    
    sum_by_genres = {}
    id_by_genres = {}
    plays_by_id = {}
    
    
    for i in range(0, len(genres)):
        if genres[i] in sum_by_genres:
            sum_by_genres[genres[i]] += plays[i]
            id_by_genres[genres[i]].append((i, plays[i]))
        else:
            sum_by_genres[genres[i]] = plays[i]
            id_by_genres[genres[i]] = [(i, plays[i])]
        plays_by_id[i] = plays[i]
    
    
    sorted_sum_by_genres = sorted(list(sum_by_genres.items()), key=lambda x : -x[1])
    
    answer = []
    
    for i in sorted_sum_by_genres:
        genre, sums = i 
        ids = id_by_genres[genre]
        result = sorted(ids, key=lambda x: (-x[1], x[0]))
        if len(result) >= 2:
            answer.append(result[0][0])
            answer.append(result[1][0])
        else:
            answer.append(result[0][0])
    
    return answer