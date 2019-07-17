movies = [
  { title: "Avatar", revenue: 2787965087 },
  { title: "Titanic", revenue: 2186772302 },
  { title: "Star Wars: The Force Awakens", revenue: 2068223624 },
  { title: "Jurassic World", revenue: 1671713208 },
  { title: "The Avengers", revenue: 1518812988 }
]

movies.map { |movie| movie[:revenue] }

total_revenue = 0
for revenue in movies
  total_revenue += revenue
end

average_revenue = total_revenue / movies.length()
puts average_revenue
