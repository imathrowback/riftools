package Huffman.magleo;

import com.google.common.io.LittleEndianDataInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class HuffmanReader
{

	private final int[] frequencies;
	private final Node root;

	static int[] toInts(final byte[] freqData)
	{
		int[] freqInts = new int[256];
		try
		{
			// do decompression
			LittleEndianDataInputStream fdis = new LittleEndianDataInputStream(new ByteArrayInputStream(freqData));
			for (int i = 0; i < 256; i++)
			{
				int f = fdis.readInt();
				freqInts[i] = f;
			}
		} catch (Exception ex)
		{
			ex.printStackTrace();
			;
		}
		return freqInts;
	}

	public HuffmanReader(final byte[] freqDataBlock)
	{
		this(toInts(freqDataBlock));
	}

	/**
	 * Initialize a new huffman reader with the given frequencies array.
	 */
	public HuffmanReader(final int[] frequencies)
	{
		this.frequencies = frequencies;
		root = buildTree2(this.frequencies);
	}

	/**
	 * Reads bytes from the given ByteBuffer, up to srcLimit compressed bytes or dstLimit uncompressed bytes.
	 */
	public byte[] read(final ByteBuffer bb, final int srcLimit, final int dstLimit)
	{
		Node current = root;

		long position = bb.position();

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		while (bb.hasRemaining() && bb.position() < position + srcLimit)
		{
			int b = bb.get() & 0xFF;
			int o = 0x80;

			do
			{

				if ((b & o) != 0)
				{
					current = current.b;
				} else
				{
					current = current.a;
				}

				o >>>= 1;

				if (current.a == null && current.b == null)
				{
					out.write(current.value & 0xFF);

					if (out.size() >= dstLimit)
					{
						return out.toByteArray();
					}

					current = root;
				}
			} while (o != 0);
		}

		return out.toByteArray();
	}

	/**
	 * Builds an huffman tree with the given frequencies array.
	 */
	private Node buildTree(final int[] freqs)
	{

		Node[] heap = new Node[freqs.length];
		for (int i = 0; i < freqs.length; ++i)
		{
			heap[i] = new Node();
			heap[i].value = i;
			heap[i].freq = freqs[i];
		}

		Node[] heap2 = new Node[heap.length];
		System.arraycopy(heap, 0, heap2, 0, heap.length);

		// heapSort3(heap2);
		heapSort(heap);

		LinkedList<Node> leafs0 = new LinkedList<>(Arrays.asList(heap));
		Collections.reverse(leafs0);

		LinkedList<Node> leafs = leafs0;

		int v = -1;
		int first = -1;
		for (int i = 0; i < leafs.size() - 1; ++i)
		{
			if (leafs.get(i).freq == v)
			{

			} else
			{
				if (first != -1 && i - first > 1)
				{
					//System.out.println("Conflicts for " + v + " from " + first + " to " + (i - 1));
					Collections.shuffle(leafs.subList(first, i - 1));
				}
				first = i;
				v = leafs.get(i).freq;
			}
		}

		//System.out.println("Leaf0 : " + leafs0);
		//System.out.println("Leaf1 : " + new ArrayList<Node>(Arrays.asList(heap2)));

		LinkedList<Node> nodes = new LinkedList<>();

		Node[] children = new Node[2];

		while (leafs.size() + nodes.size() > 1)
		{
			//System.out.println("Leafs: " + leafs);
			//System.out.println("Nodes: " + nodes);

			for (int i = 0; i < children.length; ++i)
			{
				if (leafs.isEmpty())
				{
					children[i] = nodes.poll();
				} else if (nodes.isEmpty())
				{
					children[i] = leafs.poll();
				} else
				{
					if (nodes.peek().compareTo(leafs.peek()) < 0)
					{
						children[i] = nodes.poll();
					} else
					{
						children[i] = leafs.poll();
					}
				}
			}

			Node n = new Node();
			n.freq = children[0].freq + children[1].freq;
			n.value = -1;
			n.a = children[0];
			n.a.parent = n;
			n.b = children[1];
			n.b.parent = n;

			n.depth = Math.min(n.a.depth, n.b.depth) + 1;

			int p = 0;
			while (p < nodes.size() && nodes.get(p).freq <= n.freq)
			{
				p++;
			}
			nodes.add(p, n);
		}

		return nodes.poll();
	}

	public static <C extends Comparable<C>> void heapSort(final C[] heap)
	{
		for (int i = (heap.length >> 1); i >= 1; --i)
		{
			C node = heap[i - 1];

			heapify(heap, i, node, heap.length);
		}

		for (int i = heap.length; i > 1; --i)
		{
			C node = heap[i - 1];
			heap[i - 1] = heap[0];
			heap[0] = node;

			heapify(heap, 1, node, i - 1);
		}
	}

	private static <C extends Comparable<C>> void heapify(final C[] heap, int insert, final C node, final int limit)
	{
		for (int j = insert << 1;; j <<= 1)
		{
			if (j > limit)
				break;

			if (j < limit)
			{
				if (heap[j - 1].compareTo(heap[j]) > 0)
				{
					j++;
				}
			}
			if (node.compareTo(heap[j - 1]) <= 0)
				break;

			heap[insert - 1] = heap[j - 1];
			insert = j;
		}

		heap[insert - 1] = node;
	}

	private static Node buildTree2(final int[] frequencies)
	{

		boolean debug = false;

		// The heap is twice the size of the array as we will first store pairs inside
		int[] heap = new int[2 * frequencies.length];
		for (int i = 0; i < frequencies.length; ++i)
		{
			heap[i] = i;
			heap[i + (heap.length >> 1)] = frequencies[i];
		}

		if (debug)
		{
			for (int k = 0; k < heap.length; k++)
			{
				System.out.print(heap[k] + ", ");
			}
			System.out.println();
		}

		for (int i = (heap.length >> 2); i > 0; --i)
		{
			int value = heap[i - 1];
			int weight = heap[i - 1 + (heap.length >> 1)];

			heapify2(heap, i, weight, value, (heap.length >> 1));
		}

		int prevFreq = 0;

		if (debug)
		{
			for (int k = 0; k < heap.length; k++)
			{
				System.out.print(heap[k] + ", ");
			}
			System.out.println();
		}

		int b = 0;
		int limit = heap.length >> 1;
		while (true)
		{
			b++;
			if ((b & 1) == 0)
			{
				int value = -limit;
				int weight = prevFreq + heap[0 + (heap.length >> 1)];

				heap[limit + (heap.length >> 1)] = heap[0];

				heapify2(heap, 1, weight, value, limit);
			} else
			{
				limit--;

				int value = heap[limit];
				int weight = heap[limit + (heap.length >> 1)];

				// Copy the first value of the heap as a node of the inline tree
				heap[limit] = heap[0];

				if (limit == 1)
				{
					heap[1 + (heap.length >> 1)] = value;
					break;
				}

				prevFreq = heap[0 + (heap.length >> 1)];

				heapify2(heap, 1, weight, value, limit);
			}
		}

		if (debug)
		{
			for (int k = 0; k < heap.length; k++)
			{
				System.out.print(heap[k] + ", ");
			}
			System.out.println();
		}

		return maketable(heap);
	}

	private static Node maketable(final int[] values)
	{
		int nextDepth;
		int result;
		int maxDepth = 9;
		int v9;
		int v10;
		int[] v12 = new int[32];
		int[] a3 = new int[512];
		int[] codeValues = new int[512];
		int[] codeLength = new int[512];
		int depth = 0;
		int v6 = 0;
		v12[0] = 1;
		do
		{
			result = values[(v6 & 1) * (values.length >> 1) + v12[depth]];
			if (result < 0)
			{
				nextDepth = depth + 1;
				do
				{
					if (nextDepth == maxDepth)
						a3[v6] = result;
					v6 *= 2;
					++depth;
					v12[depth] = -result;
					result = values[-result];
					++nextDepth;
				} while (result < 0);
			}
			codeValues[result] = v6;
			codeLength[result] = depth + 1;
			if (depth + 1 <= maxDepth)
			{
				if (depth + 1 == maxDepth)
				{
					a3[v6] = result;
				} else
				{
					v9 = maxDepth - (depth + 1);
					v10 = 1 << v9;
					if (1 << v9 != 0)
					{
						int v11 = v10 + (v6 << v9);
						do
						{
							--v10;
							--v11;
							v11 = result;
							a3[v11] = result;
						} while (v10 != 0);
					}
				}
			}
			do
			{
				if ((v6 & 1) == 0)
					break;
				v6 >>= 1;
				--depth;
			} while (depth >= 0);
			v6 |= 1;
		} while (depth >= 0);

		Node root = new Node();

		for (int i = 0; i < codeValues.length; ++i)
		{
			if (codeLength[i] != 0)
			{
				int mask = 1 << (codeLength[i] - 1);

				Node current = root;
				while (mask != 0)
				{
					boolean b = (codeValues[i] & mask) != 0;

					if (b)
					{
						if (current.b == null)
						{
							current.b = new Node();
						}
						current = current.b;
					} else
					{
						if (current.a == null)
						{
							current.a = new Node();
						}
						current = current.a;
					}

					mask >>>= 1;
				}

				current.value = i;

				//				  String s = "0000000000" + Integer.toBinaryString(codeValues[i]);
				//				  System.out.println(i + " => " + s.substring(s.length() - codeLength[i]));
			}
		}

		return root;
	}

	private static void heapify2(final int[] heap, int insert, final int weight, final int value, final int limit)
	{
		for (int j = insert << 1;; j <<= 1)
		{
			if (j > limit)
				break;

			if (j < limit)
			{
				if (heap[j - 1 + (heap.length >> 1)] > heap[j + (heap.length >> 1)])
				{
					j++;
				}
			}
			if (weight <= heap[j - 1 + (heap.length >> 1)])
				break;

			heap[insert - 1] = heap[j - 1];
			heap[insert - 1 + (heap.length >> 1)] = heap[j - 1 + (heap.length >> 1)];
			insert = j;
		}

		heap[insert - 1] = value;
		heap[insert - 1 + (heap.length >> 1)] = weight;
	}

	public byte[] decompress(final byte[] inputData, final int compressedSize, final byte[] dataOut, final int decompressedSize)
	{
		ByteBuffer buffer = ByteBuffer.wrap(inputData);
		byte[] outputdata = read(buffer, inputData.length, dataOut.length);
		System.arraycopy(outputdata, 0, dataOut, 0, dataOut.length);
		return outputdata;
	}

	/**
	 * An huffman tree node, be it a node or leaf
	 *
	 */
	private static class Node implements Comparable<Node>
	{
		int freq;
		int value;
		int depth;

		Node parent;
		Node a, b;

		public boolean isNode()
		{
			return a != null;
		}

		public boolean isLeaf()
		{
			return a == null;
		}

		@Override
		public int compareTo(final Node o)
		{
			int d = freq - o.freq;

			if (d == 0)
			{
				// Nodes always after
				if (isNode() && o.isLeaf())
				{
					return +1;
				} else if (isLeaf() && o.isNode())
				{
					return -1;
				}
			}

			return d;
		}

	}

}