goog.addDependency("base.js", ['goog'], []);
goog.addDependency("../cljs/core.js", ['cljs.core'], ['goog.string', 'goog.array', 'goog.object', 'goog.string.StringBuffer']);
goog.addDependency("../quiescent.js", ['quiescent'], ['cljs.core']);
goog.addDependency("../quiescent/dom.js", ['quiescent.dom'], ['cljs.core', 'quiescent']);
goog.addDependency("../css_example/core.js", ['css_example.core'], ['cljs.core', 'quiescent.dom', 'quiescent']);