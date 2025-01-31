# Write your MySQL query statement below
SELECT u.name, coalesce(SUM(r.distance), 0) AS travelled_distance
FROM users u
LEFT JOIN rides r ON u.id = r.user_id
GROUP BY u.id
ORDER BY travelled_distance DESC, u.name ASC;


