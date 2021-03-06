/*
 * Copyright 2013 Twitter Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.twitter.storehaus

import com.twitter.util.Future

/** Simple wrapper on IndexedSeq[V] to make it accessible as a ReadableStore */
class IndexedSeqReadableStore[+V](iseq: IndexedSeq[V]) extends ReadableStore[Int, V] {
  override def get(idx: Int) = if (idx >= 0 && idx < iseq.size) {
    Future.value(Some(iseq(idx)))
  } else Future.None
}
