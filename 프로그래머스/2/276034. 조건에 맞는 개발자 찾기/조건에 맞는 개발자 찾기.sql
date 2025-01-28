SELECT DISTINCT
       D.ID          AS ID
     , D.EMAIL       AS EMAIL
     , D.FIRST_NAME  AS FIRST_NAME
     , D.LAST_NAME   AS LAST_NAME
FROM   DEVELOPERS D
JOIN   SKILLCODES S
  ON   (D.SKILL_CODE & S.CODE) <> 0            -- 스킬코드의 비트가 겹치는지 확인
WHERE  S.NAME IN ('Python', 'C#')              -- 필요한 스킬만 필터
ORDER BY D.ID ASC;