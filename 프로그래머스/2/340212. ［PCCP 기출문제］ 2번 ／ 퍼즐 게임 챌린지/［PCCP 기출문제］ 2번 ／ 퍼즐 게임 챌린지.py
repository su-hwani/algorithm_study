def solution(diffs, times, limit):
    ans = 0
    length = len(diffs)
    left = 0
    right = limit

    while right-left > 1:
        level = (left + right) // 2

        now = 0
        time = 0

        while True:
            cur_time = times[now]
            prev_time = times[now - 1] if now - 1 >= 0 else 0

            if diffs[now] > level:
                time += (diffs[now] - level) * (cur_time + prev_time) + cur_time

            else:  # diffs[now] <= level
                time += times[now]

            now += 1

            if now == length or time > limit:
                break

        if time > limit:
            left = level
        elif time < limit:
            right = level
        else:
            break
    
    if time > limit: 
        return right 
    else :
        return level 

