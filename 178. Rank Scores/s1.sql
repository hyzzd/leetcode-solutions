# Write your MySQL query statement below
SELECT Score, 
    (
        SELECT COUNT(DISTINCT Score) 
        FROM Scores
        WHERE Score >= s.Score
    ) AS Rank
FROM Scores AS s
ORDER BY Score DESC
