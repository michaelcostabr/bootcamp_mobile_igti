import 'package:flutter/material.dart';
import 'package:social_app/components/custom_drawer.dart';
import 'package:social_app/models/post.dart';
import 'package:social_app/screens/comments.dart';
import 'package:social_app/services/placeholder_service.dart';

class Feed extends StatefulWidget {
  @override
  _FeedState createState() => _FeedState();
}

class _FeedState extends State<Feed> {
  final _placeholderSvc = new PlaceholderService();

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          backgroundColor: Colors.teal,
          title: Text("Feed"),
          centerTitle: true,
        ),
        drawer: CustomDrawer(),
        body: Container(
          color: Colors.white70,
          child: FutureBuilder<List<Post>>(
              future: _placeholderSvc.getPosts(),
              builder: (context, snapshot) {
                if (snapshot.hasData) {
                  return ListView.builder(
                    padding: const EdgeInsets.all(8),
                    itemCount: snapshot.data.length,
                    itemBuilder: (context, index) {
                      return GestureDetector(
                        onTap: () {
                          Navigator.push(
                              context,
                              MaterialPageRoute(
                                  builder: (context) =>
                                      Comments(snapshot.data[index].id)));
                        },
                        child: Card(
                          child: Padding(
                            padding: const EdgeInsets.all(8.0),
                            child: Column(
                              children: [
                                ListTile(
                                  title: Text(
                                    "${snapshot.data[index].title}",
                                    style: TextStyle(fontSize: 25),
                                  ),
                                  subtitle: Text("${snapshot.data[index].body}",
                                      style: TextStyle(fontSize: 20)),
                                ),
                              ],
                            ),
                          ),
                        ),
                      );
                    },
                  );
                } else if (snapshot.hasError) {
                  return Text("erro");
                }
                return Center(child: CircularProgressIndicator());
              }),
        ));
  }
}
//
// ListView.builder(
// padding: const EdgeInsets.all(8),
// itemCount: _posts.length,
// itemBuilder: (context, index) {
// return ListTile(title: Text("${_posts[index].title}"));
// })
