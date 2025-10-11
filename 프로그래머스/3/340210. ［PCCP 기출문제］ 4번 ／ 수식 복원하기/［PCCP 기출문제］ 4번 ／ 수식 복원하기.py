def solution(expressions):
    can_X = fun1(expressions)           # 항상 리스트가 되도록 fun1 수정 필요(아래 참고)
    if not can_X:                       # 가능한 진법이 하나도 없을 때 방어
        can_X = []

    can_X, can_not_X_exp = fun2(expressions, can_X)

    answers = []
    for ex in can_not_X_exp:
        ans_express, ans_R = "", None
        for k in can_X:
            express, R = fun4(ex, k)    # R은 문자열이도록 fun5 수정 필요(아래 참고)
            if not ans_express:
                ans_express, ans_R = express, R
            else:
                if ans_R != R:
                    ans_R = "?"
                    break

        if not ans_express:             # can_X가 비었거나 전부 실패한 경우
            ans_express = ex
            ans_R = "?"

        awe = ans_express.split(' ')
        if len(awe) >= 4:
            val = f"{awe[0]} {awe[1]} {awe[2]} {awe[3]} {ans_R}"
            if val not in answers:
                answers.append(val)
    return answers


def fun1(exp):
    # 최대 자리(2~9) 중 등장한 가장 큰 숫자 d를 찾아서 가능한 진법은 (d+1 .. 9)
    # 하나도 없으면 2..9 전부 허용
    max_digit = 1
    for d in range(9, 1, -1):
        s = str(d)
        if any(s in e for e in exp):
            max_digit = d
            break
    return list(range(max(max_digit + 1, 2), 10))


def fun2(exp, can_X):
    res = []
    # X인 식은 한 번만 수집(중복 제거)
    res_not = [e for e in exp if len(e.split(' ')) >= 5 and e.split(' ')[4] == "X"]

    for x in can_X:
        can = True
        for e in exp:
            se = e.split(' ')
            if len(se) < 5:
                can = False
                break

            rhs = se[4]
            if rhs == "X":
                continue                 # 미지수는 건너뛰고 검증만 진행
            if not rhs.lstrip('-').isdigit():
                can = False              # 숫자가 아니면 이 진법 x는 불가
                break

            Fs, PM, Ss, Rs = se[0], se[1], se[2], se[4]
            if not (Fs.lstrip('-').isdigit() and Ss.lstrip('-').isdigit()):
                can = False
                break

            F = fun3(int(Fs), x)
            S = fun3(int(Ss), x)
            R = fun3(int(Rs), x)
            if PM == "+":
                if F + S != R:
                    can = False
                    break
            else:
                if F - S != R:
                    can = False
                    break
        if can:
            res.append(x)
    return res, res_not


def fun3(num, x):
    neg = num < 0
    num = abs(num)
    res = 0
    p = 1
    while num >= 10:
        num, m = divmod(num, 10)
        res += p * m
        p *= x
    res += p * (num % 10)
    return -res if neg else res


def fun5(num, x):
    # 항상 문자열로 반환 + 음수 처리
    digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    if num == 0:
        return "0"
    sign = "-" if num < 0 else ""
    num = abs(num)
    re = []
    while num > 0:
        num, r = divmod(num, x)
        re.append(digits[r])
    return sign + "".join(reversed(re))


def fun4(ex, x):
    se = ex.split(" ")
    F, PM, S = int(se[0]), se[1], int(se[2])
    F1 = fun3(F, x)
    S1 = fun3(S, x)
    R = F1 + S1 if PM == "+" else F1 - S1
    R_str = fun5(R, x)                   # 문자열 보장
    return f"{F} {PM} {S} = {R_str}", R_str
    
    
    
    
    